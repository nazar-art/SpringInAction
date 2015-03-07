package com.habuma.spitter.method;

import com.habuma.spitter.domain.Spittle;
import org.springframework.security.access.prepost.PostAuthorize;

public interface SecuredInterface {
    @PostAuthorize("returnObject.spitter.username == principal.username")
    Spittle postAuthorizedSpittleMethod(Spittle spittle);

    public void unsecuredMethod();

    public void securedMethod();

    public void preAuthorizeSecuredMethod(int amount);

    public String preAndPostAuthorizedMethod(String input);

    @Sensitive
    void topSecretMethod(String x);
}
