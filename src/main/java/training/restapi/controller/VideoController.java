package training.restapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import training.restapi.Const;
import training.restapi.domain.Member;
import training.restapi.domain.Video;
import training.restapi.form.VideoForm;
import training.restapi.service.MemberService;
import training.restapi.service.VideoService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequestMapping("/video")
@RestController
public class VideoController {

    @Value("${file.dir}")
    private String fileDir;

    private final VideoService videoService;
    private final MemberService memberService;

    public VideoController(VideoService videoService, MemberService memberService) {
        this.videoService = videoService;
        this.memberService = memberService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public List<Video> videoList(HttpServletRequest request){
        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
        List<Video> videoList = videoService.findVideos(loginMember.getName());
        for (Video video: videoList){
            log.info("video={}", video);
        }
        return videoList;
    }

    @PostMapping("/upload")
    public void videoUpload(
            @RequestBody String videoName,
            @RequestParam MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);

        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            int pos = Objects.requireNonNull(originalFilename).lastIndexOf(".");
            String ext = originalFilename.substring(pos + 1);
            String saveName = videoName + "." + ext;
            videoService.saveVideo(saveName, loginMember.getName());
            String fullPath = fileDir + saveName;
            file.transferTo(new File(fullPath));
        }

        response.sendRedirect("/video/list");
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> videoDownload(
            @PathVariable Long id,
            HttpServletResponse response) throws IOException {

        Optional<Video> video = videoService.findVideoById(id);
        if (video.isEmpty()){
            response.sendRedirect("/video/list");
            return null;
        }
        String videoName = video.get().getName();
        UrlResource resource = new UrlResource("file:" + fileDir + videoName);
        String encodedName = UriUtils.encode(videoName, StandardCharsets.UTF_8);
        String contentDisposition = "attachment; filename=\"" + encodedName + "\"";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .body(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> videoRender(
            @PathVariable Long id,
            HttpServletResponse response
    ) throws IOException{
        Optional<Video> video = videoService.findVideoById(id);
        if (video.isEmpty()){
            response.sendRedirect("/video/list");
            return null;
        }
        String videoName = video.get().getName();
        UrlResource resource = new UrlResource("file:" + fileDir + videoName);
        return ResponseEntity.ok().body(resource);
    }

}
