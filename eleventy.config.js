import pugPlugin from "@11ty/eleventy-plugin-pug"
import yaml from "js-yaml"


/** @param {import("@11ty/eleventy").UserConfig} eleventyConfig */
export default async function (eleventyConfig) {
  // Configure Eleventy
  eleventyConfig.addPlugin(pugPlugin)
  eleventyConfig.addDataExtension("yaml", (contents) => yaml.load(contents))
  eleventyConfig.setOutputDirectory("dist")
  eleventyConfig.setInputDirectory("src/pages")
  eleventyConfig.setIncludesDirectory("../includes")
  eleventyConfig.setDataDirectory("../data")
  eleventyConfig.addPassthroughCopy({
    "src/assets": "/",
    "node_modules/alpinejs/dist/cdn.js": "/alpine.js"
  })
}