package org.jetbrains.dokka.tests.format

import org.jetbrains.dokka.ContentBlock
import org.jetbrains.dokka.ContentText
import org.jetbrains.dokka.DokkaConsoleLogger
import org.jetbrains.dokka.PackageDocs
import org.junit.Assert.assertEquals
import org.junit.Test

public class PackageDocsTest {
    @Test fun verifyParse() {
        val docs = PackageDocs(null, DokkaConsoleLogger)
        docs.parse("testdata/packagedocs/stdlib.md", emptyList())
        val packageContent = docs.packageContent["kotlin"]!!
        val block = (packageContent.children.single() as ContentBlock).children.first() as ContentText
        assertEquals("Core functions and types", block.text)
    }
}
