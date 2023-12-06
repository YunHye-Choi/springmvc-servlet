package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member savedMember = memberRepository.save(new Member(username, age));
        System.out.println("여긴 들어왔니");

        // Model에 데이터를 보관
        request.setAttribute("member", savedMember);
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        System.out.println("이건 되는거닝");
        requestDispatcher.forward(request, response);
        System.out.println("이건???? 되는거닝");
    }
}
