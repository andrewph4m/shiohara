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

package com.viglet.shiohara.persistence.repository.post;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.viglet.shiohara.persistence.model.post.ShPostDraft;
import com.viglet.shiohara.persistence.model.post.ShPostDraftAttr;
import com.viglet.shiohara.persistence.model.post.relator.ShRelatorItemDraft;

public interface ShPostDraftAttrRepository extends JpaRepository<ShPostDraftAttr, String> {

	List<ShPostDraftAttr> findByArrayValue(Set<String> values);

	Set<ShPostDraftAttr> findByArrayValueIn(Collection<String> values);

	List<ShPostDraftAttr> findAll();

	@Query("select p from ShPostDraftAttr p JOIN FETCH p.shPostTypeAttr where p.shPost = ?1")
	Set<ShPostDraftAttr> findByShPostAll(ShPostDraft shPost);

	Set<ShPostDraftAttr> findByShPost(ShPostDraft shPost);

	@Query("select p from ShPostDraftAttr p JOIN FETCH p.shPostTypeAttr where p.shParentRelatorItem = ?1")
	Set<ShPostDraftAttr> findByShParentRelatorItemJoin(ShRelatorItemDraft shRelatorItem);

	Set<ShPostDraftAttr> findByShParentRelatorItem(ShRelatorItemDraft shRelatorItem);

	@Query("select p from ShPostAttr p JOIN FETCH p.shPostTypeAttr where p.id = ?1")
	Optional<ShPostDraftAttr> findByIdAll(String id);

	Optional<ShPostDraftAttr> findById(String id);

	@SuppressWarnings("unchecked")
	ShPostDraftAttr save(ShPostDraftAttr shPostAttr);

	@Modifying
	@Query("delete from ShPostDraftAttr pa where pa.id = ?1")
	void delete(String shPostAttrId);

	List<ShPostDraftAttr> findAll(Specification<String> specification);
}
