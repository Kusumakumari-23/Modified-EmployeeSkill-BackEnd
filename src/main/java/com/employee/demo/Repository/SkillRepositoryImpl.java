package com.employee.demo.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.entity.Skill;
import com.employee.demo.exception.ResourceNotFoundException;

@RestController
public class SkillRepositoryImpl implements SkillRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Skill> getAllSkills() {
        String sql = "SELECT * FROM skills";
		
		RowMapper<Skill> rowMapper=new BeanPropertyRowMapper<>(Skill.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Skill findSkillById(long skillId) {
		
		try {
		
		final String SKILL_BY_ID="select * from skills where skillId=?;"; 
		
		List<Skill> query = jdbcTemplate.query(SKILL_BY_ID, new BeanPropertyRowMapper<Skill>(Skill.class), skillId);  
	    return DataAccessUtils.uniqueResult(query);
	    
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int[] batchSkillInsert(List<Skill> skills) {
		
		final String INSERT_SKILL_QUERY="insert into skills (skillId, skillName, details,empId) values(?, ?, ?, ?);";
		
		return this.jdbcTemplate.batchUpdate(INSERT_SKILL_QUERY,
			      new BatchPreparedStatementSetter() {
			      
			      @Override
			      public void setValues(PreparedStatement ps, int i) throws SQLException {
			        // emp id is auto generated so not provided
			    	ps.setLong(1,   skills.get(i).getSkillId());
			    	ps.setString(2, skills.get(i).getSkillName());
			    	ps.setString(3, skills.get(i).getDetails());
			    	ps.setLong(4,   skills.get(i).getEmpId());
			        	
			        }
			                    
			      @Override
			      public int getBatchSize() {
			          return skills.size();
			      }
			    });            
	}

	@Override
	public Skill updateSkillDetails(Skill skill) {
		
		final String UPDATE_SKILL="update skills set skillName=?, details=?, empId=? where skillId=?;";
		jdbcTemplate.update(UPDATE_SKILL,skill.getSkillName(), skill.getDetails(), skill.getEmpId(), skill.getSkillId());
		return skill;
	}

	@Override
	public void deleteSkillDetails(long skillId) {
		
     final String DELETE_BY_ID = "delete from skills where skillId=?";
		
		int size= jdbcTemplate.update(DELETE_BY_ID, skillId);
		if(size==0) {
			throw new ResourceNotFoundException("no employee with "+skillId+" to delete");
		}
		
	}

	@Override
	public Skill getSkillByempId(long empId) {
		
		try {
			
			final String SKILL_BY_ID="select * from skills where empId=?;"; 
			
			List<Skill> query = jdbcTemplate.query(SKILL_BY_ID, new BeanPropertyRowMapper<Skill>(Skill.class), empId);  
		    return DataAccessUtils.uniqueResult(query);
		    
			}catch(EmptyResultDataAccessException e) {
				return null;
			}
	}

	@Override
	public void addSkillDetails(Skill skill) {
		
		final String INSERT_SKILLS = "insert into skills (skillId, skillName, details, empId) values(?, ?, ?, ?)";
		jdbcTemplate.update(INSERT_SKILLS, skill.getSkillId(), skill.getSkillName(), skill.getDetails(), skill.getEmpId());
	}
	
	@Override
	public Skill updateSkill(long empId, Skill skill) {
		
		final String UPDATE_SKILL="update skills set skillId=?, skillName=?, details=? where empId=?;";
		jdbcTemplate.update(UPDATE_SKILL, skill.getSkillId(), skill.getSkillName(), skill.getDetails(), empId);
		return skill;
	}

}
