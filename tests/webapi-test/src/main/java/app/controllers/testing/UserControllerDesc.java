/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package app.controllers.testing;

import app.models.testing.User;
import leap.core.doc.annotation.Doc;
import leap.web.api.mvc.ApiResponse;
import leap.web.api.mvc.params.QueryOptions;

import java.util.List;

public interface UserControllerDesc {

    @Doc("doc:user_get_all.md")
    ApiResponse<List<User>> getAllUsers(QueryOptions options);

    @Doc("doc:user_doc.md#getAllWithoutPassword")
    ApiResponse<List<User>> getAllUsersWithoutPassword(QueryOptions options);

    @Doc("查询某个用户")
    ApiResponse<User> getUser(@Doc("用户id") String id, QueryOptions options);

}