package test.com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle()...");
		
		String sPath = request.getServletPath();
		log.info("sPath:{}",sPath);
		log.info("session user_id:{}",session.getAttribute("user_id"));
		
		if(sPath.equals("/m_selectAll.do")||
				sPath.equals("/m_searchList.do")||
				sPath.equals("/m_update.do")||
				sPath.equals("/m_updateOK.do")||
				sPath.equals("/m_delete.do")||
				sPath.equals("/m_deleteOK.do")||
				sPath.equals("/m_selectOne.do")){
			if(session.getAttribute("user_id")==null) {
				response.sendRedirect("m_login.do");
				return false;
			}
		}
		return true;
	}
}
