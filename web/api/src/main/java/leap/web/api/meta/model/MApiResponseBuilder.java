/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package leap.web.api.meta.model;

import leap.core.meta.MTypeManager;
import leap.lang.Builders;
import leap.lang.Collections2;
import leap.lang.http.HTTP;
import leap.lang.meta.MType;

import java.util.ArrayList;
import java.util.List;

public class MApiResponseBuilder extends MApiObjectWithDescBuilder<MApiResponse> {
	
	public static MApiResponseBuilder ok() {
		MApiResponseBuilder r = new MApiResponseBuilder();
		
		r.setStatus(HTTP.SC_OK);
		r.setSummary("Success");
		
		return r;
	}

    public static MApiResponseBuilder success(int status) {
        MApiResponseBuilder r = new MApiResponseBuilder();

        r.setStatus(status);
        r.setSummary("Success");

        return r;
    }

    protected MTypeManager typeManager;
    protected String       name;
    protected Integer      status;
    protected Class<?>     typeClass;
    protected MType        type;
    protected boolean      file;
    protected List<MApiHeaderBuilder> headers = new ArrayList<>();

    public MApiResponseBuilder() {

    }

    public MApiResponseBuilder(MApiResponse r) {
        this.name = r.getName();
        this.status = r.getStatus();
        this.type = r.getType();
        this.file = r.isFile();
        this.setSummary(r.getSummary());
        this.setDescription(r.getDescription());

        for(MApiHeader header : r.getHeaders()) {
            headers.add(new MApiHeaderBuilder(header));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    public Class<?> getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(Class<?> typeClass) {
        this.typeClass = typeClass;
    }

    public void setTypeManager(MTypeManager typeManager) {
        this.typeManager = typeManager;
    }

    public MType getType() {
		return type;
	}

	public void setType(MType type) {
		this.type = type;
	}

    public boolean isFile() {
        return file;
    }

    public void setFile(boolean file) {
        this.file = file;
    }

    public List<MApiHeaderBuilder> getHeaders() {
        return headers;
    }

    public void addHeader(MApiHeaderBuilder header) {
        headers.add(header);
    }

    @Override
    public MApiResponse build() {
        if(name == null && status == null) {
            throw new IllegalStateException("'name' or 'status' must not be specified!");
        }

        if(null == name) {
            name = String.valueOf(status);
        }

        if(typeClass != null && type == null){
            if(typeManager == null){
                throw new IllegalStateException("'typeManager' must not be specified!");
            }
            type = typeManager.getMType(typeClass);
        }

        MApiHeader[] headerArray = Builders.buildArray(headers, new MApiHeader[headers.size()]);

	    return new MApiResponse(name, summary, description, status, type, file, headerArray, attrs);
    }
	
}