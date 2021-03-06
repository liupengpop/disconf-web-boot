package com.github.knightliao.disconf.web.api.api.zookeeper.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.knightliao.disconf.web.modules.app.bo.App;
import com.github.knightliao.disconf.web.modules.app.service.AppMgr;
import com.github.knightliao.disconf.web.modules.config.form.ConfigFullModel;
import com.github.knightliao.disconf.web.modules.env.bo.Env;
import com.github.knightliao.disconf.web.modules.env.service.EnvMgr;
import com.github.knightliao.disconf.web.modules.zookeeper.form.ZkDeployForm;
import com.github.knightliao.disconf.web.support.exception.FieldException;

/**
 * @author liaoqiqi
 * @version 2014-9-11
 */
@Service
public class ZkDeployValidator {

    @Autowired
    private AppMgr appMgr;

    @Autowired
    private EnvMgr envMgr;

    /**
     * @param zkDeployForm
     *
     * @return
     */
    public ConfigFullModel verify(ZkDeployForm zkDeployForm) {

        //
        // app
        //
        if (zkDeployForm.getAppId() == null) {
            throw new FieldException("app is empty", null);
        }

        App app = appMgr.getById(zkDeployForm.getAppId());
        if (app == null) {
            throw new FieldException("app " + zkDeployForm.getAppId() + " doesn't exist in db.", null);
        }

        //
        // env
        //
        if (zkDeployForm.getEnvId() == null) {
            throw new FieldException("app is empty", null);
        }

        Env env = envMgr.getById(zkDeployForm.getEnvId());
        if (env == null) {
            throw new FieldException("env " + zkDeployForm.getEnvId() + " doesn't exist in db.", null);
        }

        //
        // version
        //
        if (StringUtils.isEmpty(zkDeployForm.getVersion())) {
            throw new FieldException("version is empty", null);
        }

        return new ConfigFullModel(app, env, zkDeployForm.getVersion(), "");
    }
}
