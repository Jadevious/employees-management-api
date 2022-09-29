package com.kainos.ea;

import com.kainos.ea.controller.RecruitmentRequests;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class nameApplication extends Application<nameConfiguration> {

    public static void main(final String[] args) throws Exception {
        new com.kainos.ea.nameApplication().run(args);
    }

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public void initialize(final Bootstrap<nameConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final nameConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new RecruitmentRequests());
    }

}
