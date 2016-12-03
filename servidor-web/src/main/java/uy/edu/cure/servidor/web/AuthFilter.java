package uy.edu.cure.servidor.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        LoginClienteBean loginBean = (LoginClienteBean) ((HttpServletRequest) request).getSession().getAttribute("loginClienteBean");
        LoginProveedorBean loginProveedorBean = (LoginProveedorBean) ((HttpServletRequest) request).getSession().getAttribute("loginProveedorBean");

        if (loginBean == null && loginProveedorBean == null) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        } else if (!loginBean.isLoggedIn() && !loginProveedorBean.isLoggedIn()) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
