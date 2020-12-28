package com.myao.exam.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;


@Controller
public class TestController {
    HttpURLConnection connection = null;

        public static void main(String[] args) throws FileNotFoundException {
            //获取文件路径
            File file = ResourceUtils.getFile( "classpath:static/images/bg.jpg");
            System.out.println(file.getAbsolutePath());
    }


}
