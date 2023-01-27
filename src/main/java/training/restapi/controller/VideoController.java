package training.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import training.restapi.service.MemberService;
import training.restapi.service.VideoService;

@RestController
public class VideoController {

    private final VideoService videoService;
    private final MemberService memberService;

    public VideoController(VideoService videoService, MemberService memberService) {
        this.videoService = videoService;
        this.memberService = memberService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/video-list")
    public String videoList(){

        return "video";
    }

}
