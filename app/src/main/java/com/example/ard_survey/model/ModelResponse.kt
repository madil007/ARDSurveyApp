package com.example.ard_survey.model

import com.google.gson.annotations.SerializedName

// its model class for map all json data to kotlin class
data class ModelResponse(

	@field:SerializedName("pageIndex")
	val pageIndex: Int? = null,

	@field:SerializedName("nextPage")
	val nextPage: String? = null,

	@field:SerializedName("generatedAt")
	val generatedAt: String? = null,

	@field:SerializedName("totalPageCount")
	val totalPageCount: Int? = null,

	@field:SerializedName("self")
	val self: String? = null,

	@field:SerializedName("pageItemCount")
	val pageItemCount: Int? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem?>? = null,

	@field:SerializedName("totalItemCount")
	val totalItemCount: Int? = null
)

data class AgeRating(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)

data class ImagesItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Institution(

	@field:SerializedName("acronym")
	val acronym: String? = null,

	@field:SerializedName("imageURL")
	val imageURL: String? = null,

	@field:SerializedName("channel")
	val channel: String? = null,

	@field:SerializedName("externalId")
	val externalId: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("coremediaId")
	val coremediaId: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class GenreCategory(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class CreditsItem(

	@field:SerializedName("contributor")
	val contributor: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("character")
	val character: String? = null
)

data class ThematicCategoriesItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class SectionsItem(

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("durationSeconds")
	val durationSeconds: Int? = null,

	@field:SerializedName("links")
	val links: Links? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Publisher(

	@field:SerializedName("institution")
	val institution: Institution? = null,

	@field:SerializedName("imageURL")
	val imageURL: String? = null,

	@field:SerializedName("externalId")
	val externalId: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("coremediaId")
	val coremediaId: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("homepageURL")
	val homepageURL: String? = null
)

data class ItemsItem(

	@field:SerializedName("longDescription")
	val longDescription: String? = null,

	@field:SerializedName("thematicCategories")
	val thematicCategories: List<ThematicCategoriesItem?>? = null,

	@field:SerializedName("genreCategory")
	val genreCategory: GenreCategory? = null,

	@field:SerializedName("keywords")
	val keywords: List<String?>? = null,

	@field:SerializedName("durationSeconds")
	val durationSeconds: Int? = null,

	@field:SerializedName("show")
	val show: Show? = null,

	@field:SerializedName("originalClipExternalId")
	val originalClipExternalId: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("coremediaId")
	val coremediaId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("availableFrom")
	val availableFrom: String? = null,

	@field:SerializedName("credits")
	val credits: List<Any?>? = null,

	@field:SerializedName("modified")
	val modified: String? = null,

	@field:SerializedName("isChildContent")
	val isChildContent: Boolean? = null,

	@field:SerializedName("hasDefaultVersion")
	val hasDefaultVersion: Boolean? = null,

	@field:SerializedName("links")
	val links: Links? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("hasSubtitles")
	val hasSubtitles: Boolean? = null,

	@field:SerializedName("isOriginalLanguage")
	val isOriginalLanguage: Boolean? = null,

	@field:SerializedName("hasSignLanguage")
	val hasSignLanguage: Boolean? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("avType")
	val avType: String? = null,

	@field:SerializedName("hasAudioDescription")
	val hasAudioDescription: Boolean? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("isOnlineOnly")
	val isOnlineOnly: Boolean? = null,

	@field:SerializedName("externalId")
	val externalId: String? = null,

	@field:SerializedName("availableTo")
	val availableTo: String? = null,

	@field:SerializedName("sections")
	val sections: List<SectionsItem?>? = null,

	@field:SerializedName("publisher")
	val publisher: Publisher? = null,

	@field:SerializedName("producer")
	val producer: String? = null,

	@field:SerializedName("subgenreCategories")
	val subgenreCategories: List<SubgenreCategoriesItem?>? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("geoAvailability")
	val geoAvailability: String? = null,

	@field:SerializedName("episodeNumber")
	val episodeNumber: Int? = null,

	@field:SerializedName("season")
	val season: Season? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("ageRating")
	val ageRating: AgeRating? = null
)

data class SubgenreCategoriesItem(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Links(

	@field:SerializedName("sky")
	val sky: Sky? = null,

	@field:SerializedName("web")
	val web: String? = null,

	@field:SerializedName("android")
	val android: String? = null,

	@field:SerializedName("hbbTV")
	val hbbTV: String? = null
)

data class Sky(

	@field:SerializedName("assetId")
	val assetId: String? = null
)

data class Show(

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("showType")
	val showType: String? = null,

	@field:SerializedName("links")
	val links: Links? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Season(

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("seasonNumber")
	val seasonNumber: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
)
