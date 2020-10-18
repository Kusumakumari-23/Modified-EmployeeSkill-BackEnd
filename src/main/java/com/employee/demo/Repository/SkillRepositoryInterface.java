package com.employee.demo.Repository;

import java.util.List;

import com.employee.demo.entity.Skill;

public interface SkillRepositoryInterface {

	public List<Skill> getAllSkills();
	Skill findSkillById(long skillId);
	Skill getSkillByempId(long empId);
	Skill updateSkillDetails(Skill skill);
    void deleteSkillDetails(long skillId);
    void addSkillDetails(Skill skill);
	
	
	public int[] batchSkillInsert(List<Skill> skills);
	Skill updateSkill(long empId, Skill skill);
}
