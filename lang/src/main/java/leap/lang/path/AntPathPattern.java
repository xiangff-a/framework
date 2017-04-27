/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package leap.lang.path;

import leap.lang.Args;

public class AntPathPattern implements PathPattern {
	
	private final AntPathMatcher matcher;
	private final String	     pattern;
	
	public AntPathPattern(String pattern){
		this(pattern,AntPathMatcher.DEFAULT_INSTANCE);
	}

	public AntPathPattern(String pattern,AntPathMatcher matcher) {
		Args.notEmpty(pattern,"pattern");
		this.pattern = pattern;
		this.matcher = matcher;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	@Override
	public boolean matches(String path) {
		return matcher.match(pattern, path);
	}

}