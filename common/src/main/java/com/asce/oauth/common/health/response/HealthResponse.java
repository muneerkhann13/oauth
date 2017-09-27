package com.asce.oauth.common.health.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthResponse {
  private String applicationName;

  private String version;

  private String startTime;

  private long duration;

  private String health;
}
