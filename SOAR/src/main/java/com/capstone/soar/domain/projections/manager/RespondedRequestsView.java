package com.capstone.soar.domain.projections.manager;

import org.springframework.beans.factory.annotation.Value;

public interface RespondedRequestsView extends PendingRequestsView{
	@Value("#{target.status.status}")
	String getStatus();
	String getManagerRemarks();

}
