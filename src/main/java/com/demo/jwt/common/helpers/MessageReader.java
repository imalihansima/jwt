package com.demo.jwt.common.helpers;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageReader {

    @Autowired
    private MessageSource source;
    private MessageSourceAccessor accessor;

    @PostConstruct
    private void init() {
        accessor = new MessageSourceAccessor(source, Locale.getDefault());
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }

    public String getMessageForResponseCode(final String code) {
        String key = String.format("%s%s",Constants.MESSAGE_CODE,code);
        return accessor.getMessage(key);
    }

    public String getMessageForResponseCode(final String code, final String field) {
        String key = String.format("%s%s",Constants.MESSAGE_CODE,code);
        return accessor.getMessage(key, new Object[]{field});
    }

    public String getMessageForMandatoryValidate(final String field) {
        return accessor.getMessage("message.code.400", new Object[]{field});
    }

}
