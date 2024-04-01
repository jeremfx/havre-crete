package userinterface.web.html;

import core.application.service.RunDTO;
import core.domain.Run;
import core.domain.script.Script;

public class PageHtml implements HtmlFragment {
    final RunDTO runDto;

    public PageHtml(RunDTO runDto) {
        this.runDto = runDto;
    }

    @Override
    public String render() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link rel="stylesheet" type="text/css" href="/style.css">
                    <title>Havre-crête</title>
                </head>
                <body>
                <section id="texte-principal">
                    <h1> Havre-crête - L'Ombre du nexus </h1>
                    <h2>%s</h2>
                    %s
                    %s
                </section>
                </body>
                </html>
                """.formatted(runDto.scriptTitle(), runDto.content(), new ChoicesHtml(runDto).render());
    }
}
