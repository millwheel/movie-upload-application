package training.restapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import training.restapi.Const;
import training.restapi.domain.Member;
import training.restapi.domain.Video;
import training.restapi.form.VideoForm;
import training.restapi.service.MemberService;
import training.restapi.service.VideoService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
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
    @GetMapping("/video/list")
    public List<Video> videoList(HttpServletRequest request){
        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
        List<Video> videoList = videoService.findVideos(loginMember.getName());
        for (Video video: videoList){
            log.info("video={}", video);
        }
        return videoList;
    }

    @PostMapping("/video/upload")
    public void videoAdd(
            @RequestPart MultipartFile file,
            @RequestPart VideoForm videoForm,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        Member loginMember = (Member)session.getAttribute(Const.LOGIN_MEMBER);
        videoService.saveVideo(videoForm.getName(), loginMember.getName());

        if (!file.isEmpty()) {
            String fullPath = fileDir + file.getOriginalFilename();
            file.transferTo(new File(fullPath));
        }

        response.sendRedirect("/video/list");
    }

}
