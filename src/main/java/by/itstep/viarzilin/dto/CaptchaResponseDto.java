package by.itstep.viarzilin.dto;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.Set;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptchaResponseDto {

    public boolean success;

    @JsonAlias("error-codes")
    public Set<String> errorCodes;
}
