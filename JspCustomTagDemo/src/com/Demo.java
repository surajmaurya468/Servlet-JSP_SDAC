package com;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.*;

public class Demo extends TagSupport{
	 
	public int doStartTag()
	{
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag()throws JspTagException
	{
		JspWriter out=pageContext.getOut();
		try {
			out.print("Custom tag implemented...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
