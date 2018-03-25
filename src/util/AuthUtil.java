package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthUtil {
	public static boolean checkUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("userInfo") != null) {
			return true;
		}
		return false;
	}
}
