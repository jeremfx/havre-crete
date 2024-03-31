package userinterface.web;

import core.application.service.Core;
import core.application.service.RunDTO;
import core.domain.RunId;
import io.javalin.Javalin;
import io.javalin.http.ContentType;
import io.javalin.http.staticfiles.Location;
import userinterface.web.html.PageHtml;

public class WebServer {

    Core core = new Core();

    public void start(int port) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.showJavalinBanner = false;
        }).start(port);

        app.get("/", ctx -> {
            RunDTO run = core.createRun();
            PageHtml pageHtml = new PageHtml(run);
            ctx.contentType(ContentType.HTML);
            ctx.result(pageHtml.render());
        });

        app.get("/run/{runId}", ctx -> {
            RunDTO run = core.getRun(new RunId(ctx.pathParam("runId")));
            PageHtml pageHtml = new PageHtml(run);
            ctx.contentType(ContentType.HTML);
            ctx.result(pageHtml.render());
        });

        app.post("/", ctx -> {
            ChoiceFormModel formModel = ChoiceForm.parseResponse(ctx.formParamMap());
            core.choose(formModel.runId(), formModel.choiceNumber());
            ctx.redirect("/run/" + formModel.runId().id());
        });

    }
}