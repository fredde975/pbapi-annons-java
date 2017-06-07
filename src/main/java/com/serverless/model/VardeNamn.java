package com.serverless.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VardeNamn {

    protected String varde;
    protected String namn;
}
