package com.example.Bai02_baitap.repository.custom.impl;

import com.example.Bai02_baitap.entity.Building;
import com.example.Bai02_baitap.repository.custom.BuildingRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor

public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Building> getAll() {
        String jpql = "select b from Building b";
        TypedQuery<Building> query = em.createQuery(jpql, Building.class);
        return query.getResultList();
    }

    @Override
    public List<Building> searchBuilding(Map<String, Object> params) {
        String s = "select b from Building b " +
                "join b.buildingRentType br " +
                "join b.assignmentBuildingList ab " +
                "where 1=1 " +
                "and b.ward like :ward " +
                "and b.street like :street " +
                "and b.district.id = :districtid " +
                "and b.rentPrice between :rentFrom and :rentTo " +
                "and ab.user.id = :staffid ";
        TypedQuery<Building> q = em.createQuery(s, Building.class);

        StringBuilder jpql = new StringBuilder(
                "select b from Building b "
        );

        List<String> keys = new ArrayList<>();
        List<Object> parameters = new ArrayList<>();

        for (String k : params.keySet()) {
            switch (k) {
                case "type":
                    jpql.append("join b.buildingRentType br ");
                    break;
                case "staffId":
                    jpql.append("join b.assignmentBuildingList ab ");
                    break;
            }
        }

        jpql.append("where 1=1 ");

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value != null && !value.toString().isBlank()) {
                switch (key) {
                    case "type":
                        jpql.append("and br.rentType.code = :type ");
                        keys.add(key);
                        parameters.add(value.toString());
                        break;
                    case "name":
                        jpql.append("and b.name like :name ");
                        keys.add(key);
                        parameters.add("%" + value + "%");
                        break;
                    case "ward":
                        jpql.append("and b.ward like :ward ");
                        keys.add(key);
                        parameters.add("%" + value + "%");
                        break;
                    case "street":
                        jpql.append("and b.street like :street ");
                        keys.add(key);
                        parameters.add("%" + value + "%");
                        break;
                    case "districtId":
                        jpql.append("and b.district.id = :districtId ");
                        keys.add(key);
                        parameters.add(value);
                        break;
                    case "rentFrom":
                        keys.add(key);
                        parameters.add(value);
                        if (params.containsKey("rentTo"))
                            jpql.append("and b.rentPrice between :rentFrom and :rentTo ");
                        else
                            jpql.append("and b.rentPrice >= :rentFrom ");
                        break;
                    case "rentTo":
                        keys.add(key);
                        parameters.add(value);
                        if (!params.containsKey("rentFrom"))
                            jpql.append("and b.rentPrice <= :rentTo ");
                        break;
                    case "staffId":
                        jpql.append("and ab.user.id = :staffId ");
                        keys.add(key);
                        parameters.add(value);
                        break;
                }
            }
        }

        try {
            TypedQuery<Building> query = em.createQuery(jpql.toString(), Building.class);
            for (int i = 0; i < keys.size(); i++) {
                query.setParameter(keys.get(i), parameters.get(i));
            }
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
