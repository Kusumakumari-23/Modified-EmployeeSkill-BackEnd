package com.employee.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.Repository.SkillRepositoryInterface;
import com.employee.demo.entity.Skill;

@Service
public class SkillServiceImpl implements SkillServiceInterface {

	@Autowired
	private SkillRepositoryInterface skillRepo;
	
	@Override
	public List<Skill> getAllSkills() {
		
		return skillRepo.getAllSkills();
	}
	
	public Skill findSkillById(long skillId) {
		
		return skillRepo.findSkillById(skillId);
	}
	
	@Override
    public int[] batchSkillInsert(List<Skill> skills) {
	
	return skillRepo.batchSkillInsert(skills);
}

	@Override
	public Skill updateSkillDetails(Skill skill) {
		
		return skillRepo.updateSkillDetails(skill);
	}

	@Override
	public void deleteSkillDetails(long skillId) {
		
	    skillRepo.deleteSkillDetails(skillId);
		
	}

	@Override
	public Skill getSkillByempId(long empId) {
		return skillRepo.getSkillByempId(empId);
	}

	@Override
	public void addSkillDetails(Skill skill) {
		skillRepo.addSkillDetails(skill);
		
	}

	@Override
	public Skill updateSkill(long empId, Skill skill) {
		return skillRepo.updateSkill(empId, skill);
	}
}
