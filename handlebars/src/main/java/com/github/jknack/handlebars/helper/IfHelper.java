/**
 * Copyright (c) 2012-2013 Edgar Espina
 *
 * This file is part of Handlebars.java.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jknack.handlebars.helper;

import java.io.IOException;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

/**
 * You can use the if helper to conditionally render a block. If its argument
 * returns false, null or empty list/array (a "falsy" value), Handlebars will
 * not render the block.
 *
 * @author edgar.espina
 * @since 0.3.0
 */
public class IfHelper implements Helper<Object> {

  /**
   * A singleton instance of this helper.
   */
  public static final Helper<Object> INSTANCE = new IfHelper();

  /**
   * The helper's name.
   */
  public static final String NAME = "if";

  @Override
  public CharSequence apply(final Object context, final Options options)
      throws IOException {
    if (options.isFalsy(context)) {
      return options.inverse(Context.newContext(options.context, context));
    } else {
      return options.fn(Context.newContext(options.context, context));
    }
  }
}
