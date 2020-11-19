package com.cajasmota.jcconf.common.db;

import com.cajasmota.jcconf.common.auth.CurrentUser;
import com.cajasmota.jcconf.common.auth.CurrentUserHolder;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class BaseModelListener {

    @PrePersist
    private void onPersist(BaseModel model) {
        Long id = getCurrentUserId();
        model.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Guatemala")));
        model.setCreatedBy(id);
    }

    @PreUpdate
    private void onUpdate(BaseModel model) {
        Long id = getCurrentUserId();
        model.setUpdatedBy(id);
        model.setUpdatedAt(LocalDateTime.now(ZoneId.of("America/Guatemala")));
    }

    private Long getCurrentUserId() {
        CurrentUserHolder currentUser = CDI.current().select(CurrentUserHolder.class, new java.lang.annotation.Annotation[0]).get();
        CurrentUser user = currentUser.get();
        return (user != null) ? user.getId() : null;
    }

}
