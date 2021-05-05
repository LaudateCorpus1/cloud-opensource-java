/*
 * Copyright 2021 Google LLC.
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

package com.google.cloud.tools.opensource.dashboard;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.junit.Test;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class TestPomTest {

  @Test
  public void testCreate() throws IOException, ValidityException, ParsingException {
    List<Artifact> dependencies = new ArrayList<>();
    Artifact artifact = new DefaultArtifact("com.google.guava:guava:30.1.1-android");
    Path created = TestPom.create(artifact, dependencies);
    assertTrue(Files.isRegularFile(created));
    
    Builder builder = new Builder();
    Document pom = builder.build(created.toFile());
    
  }
  
}
