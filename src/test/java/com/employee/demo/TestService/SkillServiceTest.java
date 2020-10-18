package com.employee.demo.TestService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;

import com.employee.demo.Repository.SkillRepositoryInterface;
import com.employee.demo.Services.SkillServiceImpl;
import com.employee.demo.entity.Skill;

@RunWith(MockitoJUnitRunner.Silent.class)
@Transactional
public class SkillServiceTest {

	@Mock
	private SkillRepositoryInterface skillRepo;
	
	@InjectMocks
	private SkillServiceImpl skillService;
	
	List<Skill> skills= Arrays.asList(
			new Skill(101L,"c","Programming Language",1L),
			new Skill(102L,"c++","oop",2L));
	
	Skill skill = new Skill(101L,"c","Programming Language",1L);
	
	@Test
	public void addSkillsTest() {
		
		skillService.batchSkillInsert(skills);
		verify(skillRepo,times(1)).batchSkillInsert(skills);
		
	}
	
	@Test
	public void getAllSkillsTest() {
		
		Mockito.when(skillRepo.getAllSkills()).thenReturn(skills);
		Assert.assertSame(skills, skillService.getAllSkills());
		
	}
	
	@Test
	public void getSkillById() {
		
		Mockito.when(skillRepo.findSkillById(101L)).thenReturn(skill);
		Assert.assertSame(101L, skillService.findSkillById(skill.getSkillId()).getSkillId());
	}
	
	@Test
	public void updateSkills() {
		
		Mockito.when(skillRepo.updateSkillDetails(skill)).thenReturn(skill);
		Assert.assertSame(101L, skillService.updateSkillDetails(skill).getSkillId());
	}
	
	@Test
	public void deleteSkillById() {
		
		skillService.deleteSkillDetails(101L);
		verify(skillRepo,times(1)).deleteSkillDetails(101L);
	}
	
	@Test
	public void getSkillsByEmpId() {
		Mockito.when(skillRepo.getSkillByempId(1L)).thenReturn(skill);
		Assert.assertSame(1L, skillService.getSkillByempId(skill.getEmpId()).getEmpId());
	}
	
}
