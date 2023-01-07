package eu.hansolo.framer;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "framer",
            version = "1.0",
            description = "A service to calculate the field of view and depth of field for a given combination of camera location, subject location, focal length, aperture, sensor type and orientation",
            contact = @Contact(name = "Gerrit Grunwald", email = "han.solo@mac.com")
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}