package com.lga.myblog.utils;

import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class FormMethodFilter extends HiddenHttpMethodFilter {

}
