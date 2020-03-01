/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.authentication;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;

import javax.inject.Singleton;

/**
 * Handles an {@link AuthorizationException} by returning an empty response with the appropriate status
 *
 * @author James Kleeh
 * @since 2.0.0
 */
@Singleton
public class HttpStatusAuthorizationExceptionHandler implements ExceptionHandler<AuthorizationException, MutableHttpResponse<?>> {

    @Override
    public MutableHttpResponse<?> handle(HttpRequest request, AuthorizationException exception) {
        return HttpResponse.status(exception.isForbidden() ? HttpStatus.FORBIDDEN :
                HttpStatus.UNAUTHORIZED);
    }
}