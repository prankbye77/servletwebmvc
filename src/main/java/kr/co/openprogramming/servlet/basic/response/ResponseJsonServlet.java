package kr.co.openprogramming.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.openprogramming.servlet.basic.dto.HelloDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        response.setCharacterEncoding("utf-8");

        HelloDto helloDto = new HelloDto();
        helloDto.setUsername("lee");
        helloDto.setAge(34);

        String result = objectMapper.writeValueAsString(helloDto);

        response.getWriter().write(result);
    }
}
