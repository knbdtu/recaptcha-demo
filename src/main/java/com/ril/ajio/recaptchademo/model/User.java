package com.ril.ajio.recaptchademo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "User")
public class User {

    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @Indexed(unique = true)
    @JsonProperty("emailId")
    private String emailId;
}
