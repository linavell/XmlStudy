/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2022-06-17 00:17:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Weather_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>기상청 육상 중기 예보(Weather.jsp)</title>\r\n");
      out.write("<!-- 부트스트랩 3.3.2 CDN -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!-- \r\n");
      out.write("stnId=108   전국\r\n");
      out.write("stnId=109   서울, 경기\r\n");
      out.write("stnId=105   강원\r\n");
      out.write("stnId=131   충북\r\n");
      out.write("stnId=133   충남\r\n");
      out.write("stnId=146   전북\r\n");
      out.write("stnId=156   전남\r\n");
      out.write("stnId=143   경북\r\n");
      out.write("stnId=159   경남\r\n");
      out.write("stnId=184   제주특별자치도\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t<h2>\r\n");
      out.write("\t\t기상 정보 <small>중기 예보</small>\r\n");
      out.write("\t</h2>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"panel-group\" role=\"group\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"panel panel-default\" role=\"group\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">지역 선택</div>\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<form method=\"get\" role=\"form\">\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"108\" checked=\"checked\" /> 전국\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"109\" /> 서울, 경기\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"105\" /> 강원\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"131\" /> 충북\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"133\" /> 충남\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"146\" /> 전북\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"156\" /> 전남\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"143\" /> 경북\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"159\" /> 경남\r\n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"stnId\" value=\"184\" /> 제주특별자치도\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">Submit</button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div><!-- close .panel-body -->\r\n");
      out.write("\r\n");
      out.write("\t\t</div><!-- close .panel .panel-default -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"panel panel-default\" role=\"group\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">기상 정보 출력</div>\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t<b>서울,경기도 육상 중기예보 - 2022년 06월 17일 (금)요일 06:00 발표</b>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t○ (하늘상태) 이번 예보기간은 대체로 흐리겠습니다.<br />\r\n");
      out.write("\t\t\t\t\t○ (기온) 이번 예보기간 아침 기온은 19~22도, 낮 기온은 25~31도로 어제(16일, 아침최저기온 16~18도, 낮최고기온 22~26도)보다 높겠습니다.<br />\r\n");
      out.write("\t\t\t\t\t○ (해상) 서해중부해상의 물결은 21일(화)과 22일(수)은 1.0~2.5m로 일겠고, 그 밖의 날은 0.5~2.0m로 일겠습니다.<br /><br />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t* 북태평양고기압의 확장 정도와 북서쪽에서 남쪽으로 내려오는 찬 공기의 강도에 따라 20일(월) 이후 강수 변동성이 크겠으니, 앞으로 발표되는 예보와 기상정보를 참고하기 바랍니다.\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3>서울</h3>\r\n");
      out.write("\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>날짜</th>\r\n");
      out.write("\t\t\t\t\t\t<th>날씨</th>\r\n");
      out.write("\t\t\t\t\t\t<th>최저/최고 기온</th>\r\n");
      out.write("\t\t\t\t\t\t<th>강수확률</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>2022-06-20 00:00</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>구름많음</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>22</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>30</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>2022-06-20 12:00</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>구름많음</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>22</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>20</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>2022-06-21 00:00</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>구름많음</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>22</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>30</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>2022-06-21 12:00</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>구름많음</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>22</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>20</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
