package dat3.carsRus.api;

import dat3.carsRus.dto.MemberRequest;
import dat3.carsRus.dto.MemberResponse;
import dat3.carsRus.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Security ADMIN
    @GetMapping
    List<MemberResponse> getMembers(){
        return memberService.findMembers();
    }

    //Security ADMIN
    @GetMapping(path = "/{username}")
    MemberResponse getMemberById(@PathVariable String username) throws Exception {
        return memberService.findMemberByUsername(username);
    }

    //Security USER
    //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    MemberResponse addMember(@RequestBody MemberRequest body){
        return memberService.addMember(body);
    }

    //Just to demonstrate that clients can control type of what they get back
  /*  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
    String addMember2(@RequestBody MemberRequest body){
        return null;
    }*/

    //Security USER/ADMIN ?
    @PutMapping("/{username}")
    ResponseEntity<Boolean> editMember(@RequestBody MemberRequest body, @PathVariable String username){
        return null;
    }

    //Security ADMIN
    @PatchMapping("/ranking/{username}/{value}")
    void setRankingForUser(@PathVariable String username, @PathVariable int value) {

    }

    // Security ADMIN
    @DeleteMapping("/{username}")
    void deleteMemberByUsername(@PathVariable String username) {

    }



}
