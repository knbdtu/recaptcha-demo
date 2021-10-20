package com.ril.ajio.recaptchademo.validator;

import com.ril.ajio.recaptchademo.model.CaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CaptchaValidator {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${google.recaptcha.verify.url}")
    private String googleReCaptchaVerifyUrl;

    @Value("${google.recaptcha.key.secret}")
    private String googleReCaptchaSecretKey;

    public boolean isValidCaptcha(String captcha) {

        String url= googleReCaptchaVerifyUrl;
        String params="?secret=" + googleReCaptchaSecretKey + "&response=" + captcha;
        String completeUrl=url+params;
        CaptchaResponse captchaResponse = restTemplate.postForObject(completeUrl, null, CaptchaResponse.class);
        return captchaResponse.isSuccess();
    }
}
