package com.cmsbackend.utils.random_code;

import java.util.Random;

public class RandomCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890123456789";

    private static final int CODE_LENGTH = 6; // 验证码长度

    public static String generateRandomCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }

        return code.toString();
    }
}
