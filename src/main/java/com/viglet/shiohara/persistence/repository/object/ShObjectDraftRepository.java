/*
 * Copyright (C) 2016-2019 Alexandre Oliveira <alexandre.oliveira@viglet.com> 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.viglet.shiohara.persistence.repository.object;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.viglet.shiohara.persistence.model.auth.ShGroup;
import com.viglet.shiohara.persistence.model.object.ShObjectDraft;

public interface ShObjectDraftRepository extends JpaRepository<ShObjectDraft, String> {

	List<ShObjectDraft> findAll();

	Optional<ShObjectDraft> findById(String id);
	
	@SuppressWarnings("unchecked")
	ShObjectDraft save(ShObjectDraft shObject);

	int countByIdAndShGroupsInOrIdAndShGroupsIsNull(String id,Collection<ShGroup> groups, String id2);
	@Modifying
	@Query("delete from ShObjectDraft od where od.id = ?1")
	void delete(String shObjectId);
}
