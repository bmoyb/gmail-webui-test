package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by mo_brian on 11/11/15.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Major.class})
public interface Major {
}
