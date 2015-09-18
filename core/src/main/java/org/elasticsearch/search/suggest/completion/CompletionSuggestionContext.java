/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.search.suggest.completion;

import org.elasticsearch.index.fielddata.IndexFieldDataService;
import org.elasticsearch.index.mapper.MapperService;
import org.elasticsearch.index.mapper.core.CompletionFieldMapper;
import org.elasticsearch.search.suggest.Suggester;
import org.elasticsearch.search.suggest.SuggestionSearchContext;
import org.elasticsearch.search.suggest.completion.context.ContextMapping;

import java.util.Map;
import java.util.Set;

/**
 *
 */
public class CompletionSuggestionContext extends SuggestionSearchContext.SuggestionContext {

    private CompletionFieldMapper.CompletionFieldType fieldType;
    private CompletionSuggestionBuilder.FuzzyOptionsBuilder fuzzyOptionsBuilder;
    private CompletionSuggestionBuilder.RegexOptionsBuilder regexOptionsBuilder;
    private Map<String, ContextMapping.QueryContexts> queryContexts;
    private MapperService mapperService;
    private IndexFieldDataService fieldData;
    private Set<String> payloadFields;

    CompletionSuggestionContext(Suggester suggester) {
        super(suggester);
    }

    CompletionFieldMapper.CompletionFieldType getFieldType() {
        return this.fieldType;
    }

    void setFieldType(CompletionFieldMapper.CompletionFieldType fieldType) {
        this.fieldType = fieldType;
    }

    CompletionSuggestionBuilder.RegexOptionsBuilder getRegexOptionsBuilder() {
        return regexOptionsBuilder;
    }

    void setRegexOptionsBuilder(CompletionSuggestionBuilder.RegexOptionsBuilder regexOptionsBuilder) {
        this.regexOptionsBuilder = regexOptionsBuilder;
    }

    CompletionSuggestionBuilder.FuzzyOptionsBuilder getFuzzyOptionsBuilder() {
        return fuzzyOptionsBuilder;
    }

    void setFuzzyOptionsBuilder(CompletionSuggestionBuilder.FuzzyOptionsBuilder fuzzyOptionsBuilder) {
        this.fuzzyOptionsBuilder = fuzzyOptionsBuilder;
    }

    void setQueryContexts(Map<String, ContextMapping.QueryContexts> queryContexts) {
        this.queryContexts = queryContexts;
    }

    Map<String, ContextMapping.QueryContexts> getQueryContexts() {
        return queryContexts;
    }

    void setMapperService(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    MapperService getMapperService() {
        return mapperService;
    }

    void setFieldData(IndexFieldDataService fieldData) {
        this.fieldData = fieldData;
    }

    IndexFieldDataService getFieldData() {
        return fieldData;
    }

   void setPayloadFields(Set<String> fields) {
        this.payloadFields = fields;
    }

    Set<String> getPayloadFields() {
        return payloadFields;
    }
}
