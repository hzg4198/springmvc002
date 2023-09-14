package com.cuit.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

/**
 * 閺勫墽銇氶弽鐓庣础 娑撳﹣绔撮敓锟�1 2 3 4 5 娑撳绔撮敓锟�
 */
public class NavigationTag extends TagSupport {
    static final long serialVersionUID = 2372405317744358833L;

    /**
     * request 娑擃厾鏁ゆ禍搴濈箽鐎涙ザage<E> 鐎电钖勯惃鍕綁闁插繐鎮�,姒涙顓绘稉鐚存嫹?page閿燂拷
     */
    private String bean = "page";

    /**
     * 閸掑棝銆夌捄瀹犳祮閻ㄥ増rl閸︽澘娼�,濮濄倕鐫橀幀褍绻�閿燂拷
     */
    private String url = null;

    /**
     * 閺勫墽銇氭い鐢电垳閺佷即鍣�
     */
    private int number = 5;

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Page page = (Page)request.getAttribute(bean);
        if (page == null)
            return SKIP_BODY;
        url = resolveUrl(url, pageContext);
        try {
            //鐠侊紕鐣婚幀濠氥�夐敓锟�
            int pageCount = page.getTotal() / page.getSize();
            if (page.getTotal() % page.getSize() > 0) {
                pageCount++;
            }
            writer.print("<nav><ul class=\"pagination\">");
            //閺勫墽銇氶垾婊�绗傞敓锟介敓鏂ゆ嫹閳ユ繃瀵滈敓锟�
            if (page.getPage() > 1) {
                String preUrl = append(url, "page", page.getPage() - 1);
                preUrl = append(preUrl, "rows", page.getSize());
                writer.print("<li><a href=\"" + preUrl + "\">上一页</a></li>");
            } else {
                writer.print("<li class=\"disabled\"><a href=\"#\">下一页</a></li>");
            }
            //閺勫墽銇氳ぐ鎾冲妞ょ數鐖滈惃鍕2妞ょ數鐖滈崪灞芥倵娑撱倝銆夐敓锟�
            //閿燂拷 閿燂拷1 2 3 4 5, 閿燂拷 閿燂拷1 2 3 4 5, 閿燂拷 閿燂拷 2 3 4 5,
            //閿燂拷 閿燂拷2 3 4 5 6 ,閿燂拷0  閿燂拷8 9 10 11 12
            int indexPage = (page.getPage() - 2 > 0)? page.getPage() - 2 : 1;
            for(int i=1; i <= number && indexPage <= pageCount; indexPage++, i++) {
                if(indexPage == page.getPage()) {
                    writer.print( "<li class=\"active\"><a href=\"#\">"+indexPage+"<span class=\"sr-only\">(current)</span></a></li>");
                    continue;
                }
                String pageUrl  = append(url, "page", indexPage);
                pageUrl = append(pageUrl, "rows", page.getSize());
                writer.print("<li><a href=\"" + pageUrl + "\">"+ indexPage +"</a></li>");
            }
            //閺勫墽銇氶垾婊�绗呴敓锟介敓鏂ゆ嫹閳ユ繃瀵滈敓锟�
            if (page.getPage() < pageCount) {
                String nextUrl  = append(url, "page", page.getPage() + 1);
                nextUrl = append(nextUrl, "rows", page.getSize());
                writer.print("<li><a href=\"" + nextUrl + "\">上一页</a></li>");
            } else {
                writer.print("<li class=\"disabled\"><a href=\"#\">下一页</a></li>");
            }
            writer.print("</nav>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    private String append(String url, String key, int value) {

        return append(url, key, String.valueOf(value));
    }

    /**
     * 娑撶皫rl 閸欏倸濮為崣鍌涙殶鐎电懓鍔�
     *
     * @param url
     * @param key
     * @param value
     * @return
     */
    private String append(String url, String key, String value) {
        if (url == null || url.trim().length() == 0) {
            return "";
        }

        if (url.indexOf("?") == -1) {
            url = url + "?" + key + "=" + value;
        } else {
            if(url.endsWith("?")) {
                url = url + key + "=" + value;
            } else {
                url = url + "&amp;" + key + "=" + value;
            }
        }

        return url;
    }

    /**
     * 娑撶皫rl 濞ｈ濮炵紙濠氥�夌拠閿嬬湴閸欏倹鏆�
     *
     * @param url
     * @param pageContext
     * @return
     * @throws javax.servlet.jsp.JspException
     */
    private String resolveUrl(String url, javax.servlet.jsp.PageContext pageContext) throws JspException{
        //UrlSupport.resolveUrl(url, context, pageContext)
        Map params = pageContext.getRequest().getParameterMap();
        for (Object key:params.keySet()) {
            if ("page".equals(key) || "rows".equals(key)) continue;
            Object value = params.get(key);
            if (value == null) continue;
            if (value.getClass().isArray()) {
                url = append(url, key.toString(), ((String[])value)[0]);
            } else if (value instanceof String) {
                url = append(url, key.toString(), value.toString());
            }
        }
        return url;
    }



    /**
     * @return the bean
     */
    public String getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(String bean) {
        this.bean = bean;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
