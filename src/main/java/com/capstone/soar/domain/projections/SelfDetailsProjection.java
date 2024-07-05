package com.capstone.soar.domain.projections;

import org.springframework.beans.factory.annotation.Value;

public interface SelfDetailsProjection {
	String getEmail();
	String getName();
	@Value("#{target.role.role}")
	String getRole();
}
