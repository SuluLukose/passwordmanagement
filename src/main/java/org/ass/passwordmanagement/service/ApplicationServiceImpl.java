package org.ass.passwordmanagement.service;

import org.ass.passwordmanagement.dto.AppResponseDto;
import org.ass.passwordmanagement.dto.ApplicationDto;
import org.ass.passwordmanagement.entity.ApplicationEntity;
import org.ass.passwordmanagement.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
private ApplicationRepository applicationRepository;

	@Override
	public AppResponseDto processCreateApp(ApplicationDto applicationDto) {
		AppResponseDto appResponseDto = null;
		try {
		ApplicationEntity applicationEntity = new ApplicationEntity();
		applicationEntity.setAppName(applicationDto.getAppName());
		applicationEntity.setUrl(applicationDto.getAppUrl());
		applicationEntity.setAppType(applicationDto.getAppType());
		applicationEntity.setPassword(applicationDto.getPassword());
		applicationEntity.setStatus(applicationDto.getStatus());
		
			ApplicationEntity savedObj = applicationRepository.save(applicationEntity);
			if (savedObj == null) {
				appResponseDto = new AppResponseDto("FAILURE", "500", null, null);
			}
			appResponseDto = new AppResponseDto("SUCCESS", "200", savedObj, null);
		} catch (Exception e) {
			appResponseDto = new AppResponseDto("FAILURE", "500", null, e.getLocalizedMessage());
		}
		return appResponseDto;
	}

	@Override
	public AppResponseDto getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}