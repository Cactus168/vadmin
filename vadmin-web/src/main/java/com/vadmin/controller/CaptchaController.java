package com.vadmin.controller;

import com.google.code.kaptcha.Producer;
import com.vadmin.common.constant.Constants;
import com.vadmin.service.RedisService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
public class CaptchaController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Resource
    private RedisService redisService;

    /**
     * 验证码
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletResponse response, String uuid)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        String capStr = null, code = null;
        BufferedImage image = null;
        // 保存验证码信息
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        //生成文字验证码
        String capText = captchaProducerMath.createText();
        capStr = capText.substring(0, capText.lastIndexOf("@"));
        code = capText.substring(capText.lastIndexOf("@") + 1);
        //获取图片验证码
        image = captchaProducerMath.createImage(capStr);
        System.out.println(".....>>>>"+code);
        //放入redis中
        redisService.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 输出到页面
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

}
