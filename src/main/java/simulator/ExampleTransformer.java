package simulator;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class ExampleTransformer extends ResponseDefinitionTransformer {

    @Override
    public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files, Parameters parameters) {
        int value = parameters.getInt("someValue");
        return new ResponseDefinitionBuilder()
                .withHeader("Any-Header", "Transformed Header")
                .withStatus(201)
                .withBody("Transformed Body " + value)
                .build();
    }

    @Override
    public String getName() {
        return "example-transformer";
    }

    @Override
    public boolean applyGlobally() {
        return false;
    }

}
