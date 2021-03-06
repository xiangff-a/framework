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

package leap.web;

import leap.web.route.Route;

import java.util.Map;

public interface Router {

    /**
     * Returns a matched {@link Route} or <code>null</code> if no route matched.
     */
    Route match(String method, String path, Map<String, Object> inParameters, Map<String, String> outVariables);

    /**
     * Returns <code>true</code> if the request has been handled when no route exists.
     */
    default boolean handleNotFound(Request request, Response response, String path) {
        return false;
    }

}