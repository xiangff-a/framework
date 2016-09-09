/*
 *
 *  * Copyright 2016 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package leap.orm.mapping;

import leap.lang.Buildable;

public class RelationPropertyBuilder implements Buildable<RelationProperty> {

    protected String  name;
    protected boolean many;
    protected String  relation;
    protected String  targetEntityName;
    protected String  joinEntityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMany() {
        return many;
    }

    public void setMany(boolean many) {
        this.many = many;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getTargetEntityName() {
        return targetEntityName;
    }

    public void setTargetEntityName(String targetEntityName) {
        this.targetEntityName = targetEntityName;
    }

    public String getJoinEntityName() {
        return joinEntityName;
    }

    public void setJoinEntityName(String joinEntityName) {
        this.joinEntityName = joinEntityName;
    }

    @Override
    public RelationProperty build() {
        return new RelationProperty(name, many, targetEntityName, joinEntityName);
    }
}