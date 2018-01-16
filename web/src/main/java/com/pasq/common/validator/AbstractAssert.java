package com.pasq.common.validator;

import com.pasq.common.exception.ResultsException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * @author wwx
 * @email wangweixin@pasq.com
 * @date 2017年11月29日
 */
public abstract class AbstractAssert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new ResultsException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new ResultsException(message);
        }
    }
}
