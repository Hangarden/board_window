package hello.login.web.member;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") MemberCreateForm createForm) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute MemberCreateForm form, BindingResult bindingResult) { //BindingResult는 검증 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공하는 객체입니다.
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }
        // 검증 로직 화면이나 컨트롤러에서 혹은 둘다도 가능
//        if (ObjectUtils.isEmpty(member.getLoginId())) {
//            errors.put("loginId", "아이디를 입력하셔야합니다.");
//                    bindingResult.addError(new FieldError("member"
//                            , "loginId"
//                            , "아이디를 입력하셔야합니다."));
//        }

        if (!form.getPassword().equals(form.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "members/addMemberForm";
        }

        memberService.save(form);
        return "redirect:/";
    }

    //아이디 중복체크
    @PostMapping("add/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("loginId") String loginId) {

        int cnt = memberService.idCheck(loginId);
        return cnt;

    }

    @PostMapping("add/phoneCheck")
    @ResponseBody
    public int NumberCheck(@RequestParam("phoneNumber") String phoneNumber) {

        int cnt = memberService.numberCheck(phoneNumber);
        return cnt;

    }

}
